# Overview
OERClient is an openexchangerates.org client for Java and Android.  It handles HTTP connection and JSON deserialization into native types.  All OER services are exposed via the [OERClient](http://kgilmer.github.com/org.openexchangerate.client/org/openexchangerates/client/OERClient.html) class.

# Example
Print the all the latest rates and currencies
``` java
	OERClient oerClient = new OERClient();
	Map<String, Double> rates = oerClient.getLatestRates();
	
	for (Map.Entry<String, Double> entry : rates) {
		System.out.println("Currency: " + entry.getKey() + " Value: " + entry.getValue());
	}
```

# Dependencies
OERClient internally uses the native HTTPUrlConnection HTTP client and depends on the org.json JSON library (which is bundled with the Android class libraries).

# License
OERClient is Apache licensed and used in production for Android applications that use the openexchangerates.org service.

# Further Reading
See http://kgilmer.github.com/org.openexchangerate.client/ for library javadoc and http://openexchangerates.org/ for more information on the web service.
