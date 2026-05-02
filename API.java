import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class API {
	private final HttpClient client;
	private final String url = "https://firms.modaps.eosdis.nasa.gov/api/area/csv/83a29c21b009d77caa842ade2b3fd275/VIIRS_SNPP_NRT/-124.848974,45.543541,-116.915989,49.002494/1";

	public API() {
		this.client = HttpClient.newHttpClient();
	}

	public String get() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}

	public String post(String json) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
}
