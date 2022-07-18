
# Clean architecture template
This repository contains a clean architecture template

## Modules

This project is composed of several modules, each one has its own responsibility:

**app** –  application definition, creation of dependency graph

**cache** – database management to store a library of albums

**common** – code shared between modules

**data** – data management provide repository to domain module by using cache and remote modules

**designsystem** – app theme and reusable UI components

**domain** – use case to fetch albums

**presentation** – activities and fragments displayed to the user

**remote** – fetch data from remote server

**testing** – libraries and extensions to test other modules


## Technical choices / Libraries

**buildSrc** – Definition of all modules, libraries that can be used by other modules.

**gradle kts** – Build scripts are written in Kotlin instead of Groovy which is very handy.

**koin** – Easy way to create the dependency graph. I could have used Hilt/Dagger but Koin is so easy...

**MVVM / Live Data** – Nice architecture component from Google. ViewModels are injected from the fragments using Koin. The UI can be later easily migrated to Jetpack Compose using the exact same logic.

**navigation component** – By using a single activity, the navigation management can become messy if we have to deal with fragment transactions. Also help a lot to deal with configuration changes.

**shared elements** – Make the transition between list and details fragments beautiful by moving the album image.

**RxJava** – I could have used coroutines but I'm more familiar with RxJava. Used by the viewmodel, usecase, database and networking

**Room** – Easy way to create and manage cache without writing SQLite things

**Okhttp x Retrofit** – No need to present it :)

**coil** – Probably the most performant lib today to load images from internet with cache capabilities

**lottie** – Used to display a beautiful animation while the library is loading

**fragmentviewbindingdelegate** – View binding in fragments requires some boilerplate, this library avoid that work

**mockk** – Mockito is great, but mockk is designed specially for Kotlin
 
