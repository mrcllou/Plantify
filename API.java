import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class API {
	private final HttpClient client;
	private final String MAP_KEY = "83a29c21b009d77caa842ade2b3fd275";
	private final double MIN_LONGITUDE = -124.848974;
	private final double MAX_LONGITUDE = -116.915989;
	private final double MIN_LATITUDE = 45.543541;
	private final double MAX_LATITUDE = 49.002494;

	private String url;

	public API() {
		client = HttpClient.newHttpClient();
		url = "https://firms.modaps.eosdis.nasa.gov/api/area/csv/";
		url += MAP_KEY;
		url += "/VIIRS_SNPP_NRT/";
		url += MIN_LONGITUDE + ",";
		url += MIN_LATITUDE + ",";
		url += MAX_LONGITUDE + ",";
		url += MAX_LATITUDE;
		url += "/1";
	}

	public String get() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
}
