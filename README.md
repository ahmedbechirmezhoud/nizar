This is a bestselling book app that utilizes the New York Times Books API to display the bestseller books for each category for the current week. The app consists of three screens: a welcome fragment, a book list fragment, and a book details fragment, as shown in the screenshots below:

![Welcome Fragment](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/fa0b1aea-64af-4dc0-9382-e7c07610a160)
![Book List Fragment](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/3bbfc6fe-4dce-4b03-8fcf-fdcbd1f57d3d)
![Book Details Fragment](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/501b762f-3c22-4bb3-a7a1-900f498bc519)

The app implements navigation in Kotlin for cleaner and more maintainable code, as depicted in the screenshot below:

![Navigation](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/8e699003-3094-4c70-9af1-8be0e3a20d1e)

The app comprises five fragments, including the three mentioned above. Two additional fragments handle specific scenarios. The first one is displayed when there is a loss of connection, implemented using the native Connectivity Manager provided by Android. A custom callback function is defined to execute whenever the connection state changes. This state is then stored in a ConnectivityViewModel, which is observed in the main activity. The app switches fragments based on the current state value.

The second additional fragment is the BookListDetailsFragment, utilized in the BookListAdapter to display individual items in the RecyclerView. Data from the API is obtained via a ViewModel with access to the BooksAPI defined using Retrofit. The data is observed as it is populated via the API, and then passed to the RecyclerView for handling the display of data.
