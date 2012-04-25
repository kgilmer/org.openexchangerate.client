OERClient is an openexchangerates.org client for Java and Android.  It handles HTTP connection and JSON deserialization into native types.  All OER services are exposed via the OERClient class.

OERClient internally uses the native HTTPUrlConnection HTTP client and depends on the org.json JSON library (which is bundled with the Android class libraries).

OERClient is Apache licensed and used in production for Android applications that use the openexchangerates.org service.

See http://openexchangerates.org/ for more information.