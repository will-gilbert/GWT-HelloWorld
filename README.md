Here are some very small demonstration projects which show the various level of implementing dependency injection, loose coupling and events in GWT using a 'HelloWorld' application which get its response from a server. No need to actually build and run these applications walking through the source is simple enough to follow.

Each demo has its own Gradle build file.  You can easily install Gradle using [SDKMan](http://sdkman.io).


**1-HelloWorld-Simple** -- A button and alert tied together in the same class. Very JavaScript-like.  Difficult to test, not scaleable

**2-HelloWorld-RPC** -- Uses GWT Remote Procedure Call to get a server response. Also difficult to test and not scalable.

**3-HelloWorld-MVP** -- Builds on the RPC example but uses the Model-View-Presenter (MVP) pattern. Still difficult to test because of lack of interfaces, but starting to show scalability by splitting out the responsibilities.

**4-HelloWorld-DI** -- Continuing to build on RPC and MVP examples and now using interfaces with dependency injection using Google GIN. However, the number of files has doubled because each interface is a seperate file, yet contains very little content.  With interfaces in place we can now start to do some testing with Mockito. The tests contain an example of testing anonymous inner classes with Mockito.

**5-HelloWorld-InnnerIntf** -- Same as '_4-HelloWorld-DI_' but the interfaces have been moved inside of the Presenter class (HelloWorldPresenter). The seperate interface files are gone and the Presenter constructor has been cleaned up.  The Presenter is now the main focus of the coding effort while the view is simply a collection of widgets and the model acts as both a gateway to the service and/or a POJO.

**6-HelloWorld-EventBus** -- Not a useful example of MVP but this demo illustrates how to create and send and receive events via an application wide Event Bus.  Here the model is optional but was kept as a POJO.  Also note in this example that the error event is consumed by both the HelloWorldPresenter and the ErrorPresenter classes. Also notice that the ErrorPresenter defines both View and Model inner interfaces but does not implement them -- Loose coupling in action.

**7-HelloWorld-EventBinder** -- The same as '_6-HelloWorld-EventBus_' but uses the EventBinder library to greatly simplify using the EventBus.

**8-HelloWorld-UiBinder** -- Using GWT's UIBinder XML to create the widgets of the view.

--will gilbert

