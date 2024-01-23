This is a book bestseller app, it uses new york times books api and show the best seller books for this week for each categorie ,it is composed of three screens, a welcome framgnet, a book list fragment, and a book details fragment as show below in the screen shots

![image](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/fa0b1aea-64af-4dc0-9382-e7c07610a160)
![image](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/3bbfc6fe-4dce-4b03-8fcf-fdcbd1f57d3d)
![image](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/501b762f-3c22-4bb3-a7a1-900f498bc519)

We also implemented navigation in kotlin for cleaner more maintainable code

![image](https://github.com/YassineRaboudi007/MobileBookApp/assets/93160741/8e699003-3094-4c70-9af1-8be0e3a20d1e)

We have mainly 5 fragments , the three we mentioned above and two more, one that is displayed when connection is lost, this is implemented by using the native connectivity manager provided by android, and defining our custom callback
functions to be executed whenever the connection state changes, this state is then put in a ConnectivityViewModel, which is then used in the main activity, where we observer that state variable and then switch fragments depending 
on the value of the current state

The other fragment is BookListDetailsFragment, which is used in the BookListAdapter to show each individual item in the recycle view, we get the data from the api via a viewModel which has access to BooksAPI defined using 
retrofit, and we observer the data being populated via the api, then we pass that data to the RecycleView for it to handle the displaying of the data

