package target2024.java8;

import java.sql.ResultSet;
import java.util.Queue;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

final class finalA {
	public void func()  {
		System.out.println("A");
	}
}

//Can't be done
//class B extends finalA {
//	
//}

class privateB {
	private privateB() {
		
	}
}

//Can't be done
//class C extends B {
//	
//}


interface Connection {
    ResultSet use(String query);
    
    void close();

}


// TODO implement a Postgres Connection pool
// int: Connection <-- PostgresConnection
// class ConnectionPool



//Design Pattern: Singleton

//ConnectionPool --> 
//	get --> connection


@Getter
class ConnectionFacade implements Connection {
		
	Connection connection;
	ConnectionPool connectionPool;
  
	  @Setter
	  boolean isAvailable;
  
  	ConnectionFacade(ConnectionPool connectionPool) {
	    connection = new PostgresConnection();
        isAvailable = true;
        this.connectionPool = connectionPool;
        
    }
  
  	public void close() {
  		connection.close();
  		this.isAvailable = true;
  		connectionPool.updateConnectionFacade(this);
    }
    
	@Override
	public ResultSet use(String query) {
    	return connection.use(query);    	
	}
}

class ConnectionPool {
    
  	Queue<ConnectionFacade> queue;  	
    Object lock;
  
    public ConnectionPool(int n) {
      for(int i=0; i<n; i++) {
        queue.add(new ConnectionFacade(this));
      }
      lock = new Object();
    }
    
    @SneakyThrows
    public Connection getConnection() {
    		
        synchronized(lock) {
          if(queue.isEmpty()) {
			lock.wait();
          }
        }
        
        ConnectionFacade cf = queue.poll();
        cf.setAvailable(false);
      	return cf;
    }
    
    public void updateConnectionFacade(ConnectionFacade cf) {
    	queue.add(cf);
        lock.notifyAll();
    }
}


// Sample client code, cannot touch


// Available Library class, cannot touch
final class PostgresConnection implements Connection {
    public PostgresConnection() {
      // Initialization done to connect to database
    }
    public ResultSet use(String query) {
    	return null;
     // Logic already implemented here
     }
    
    public void close() {
     // Logic already implemented here which 
     // destroys the connection and it cannot be used further
    }
}


public class FinalClassDemo {
	public static void main(String[] args) {
		 ConnectionPool pool = new ConnectionPool(10);
		 Connection connection = pool.getConnection();
		  
		 try {
		    connection.use("select * from table");
		 } finally {
		     connection.close();
		 }
	}
}
