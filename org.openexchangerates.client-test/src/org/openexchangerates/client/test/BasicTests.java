package org.openexchangerates.client.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import junit.framework.TestCase;

import org.json.JSONException;
import org.openexchangerates.client.OERClient;
import org.openexchangerates.client.RestClient;

/**
 * Happy-path tests for OER client.  Can be used as an example of how to use the client.
 * 
 * @author kgilmer
 *
 */
public class BasicTests extends TestCase {

	/**
	 * Test getCurrencies() method.
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */
	public void testGetCurrencies() throws IOException, JSONException {
		OERClient oerClient = getClient();
		
		Map<String, String> currencies = oerClient.getCurrencies();
		
		assertNotNull(currencies);
		assertTrue(currencies.size() > 0);
		assertTrue(currencies.containsKey("USD"));
	}
	
	/**
	 * Test getRates(Date) method.
	 * @throws IOException
	 * @throws JSONException
	 */
	public void testGetRates() throws IOException, JSONException {
		OERClient oerClient = getClient();
		
		//Use known-to-be-good date.
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DAY_OF_MONTH, 25);
		
		Map<String, Double> rates = oerClient.getRates(cal.getTime());
		
		assertNotNull(rates);
		
		assertTrue(rates.size() > 0);		
	}
	/**
	 * Test getLatestRates method.
	 * @throws JSONException
	 * @throws IOException
	 */
	public void testGetLatestRates() throws JSONException, IOException {
		OERClient oerClient = getClient();
		
		Map<String, Double> rates = oerClient.getLatestRates();
		
		assertNotNull(rates);
		
		assertTrue(rates.size() > 0);		
	}
	
	/**
	 * Test can get valid timestamp from OER service.
	 * @throws JSONException 
	 * @throws IOException 
	 */
	public void testGetTimestamp() throws IOException, JSONException {
		OERClient oerClient = getClient();
		
		Date ts = oerClient.getTimestamp();
		
		assertNotNull(ts);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(ts.getTime());
		assertTrue(c.get(Calendar.YEAR) > 2011);
	}
	
	/**
	 * @return client instance for testing.
	 */
	private OERClient getClient() {
		return new OERClient(
				null, 
				OERClient.DEFAULT_OER_URL, 
				OERClient.DEFAULT_CONNECT_TIMEOUT, 
				OERClient.DEFAULT_READ_TIMEOUT, 
				new PrintWriter(System.out), 
				RestClient.THROW_ALL_ERRORS);
	}
}
