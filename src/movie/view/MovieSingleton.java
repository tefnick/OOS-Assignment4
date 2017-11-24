package movie.view;



public class MovieSingleton {
		//need an arbitrary object to manage the concurrency lock in getInstanceMultiThread2
		private static final Object lock = new Object();

		//use volatile if multi-threaded access to singleton 
		private static volatile MovieSingleton singleton = null;
			
		private MovieSingleton() {
			
		}

		/**
		 * nice and simple when app is single-threaded
		 * 
		 * @return
		 */
		public static MovieSingleton getInstanceSingleThread() {
			if(singleton == null) {
				singleton = new MovieSingleton();
			}
			return singleton;
		}
		
}
