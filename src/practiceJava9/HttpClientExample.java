package practiceJava9;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class HttpClientExample {
	public static void main(String[] args) {
		sendSyncRequest();
		sendAsyncRequest();
	}

	private static void sendAsyncRequest() {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(URI.create("https://postman-echo.com/get")).GET().build();
			CompletableFuture<HttpResponse<String>> future = client.sendAsync(request,
					HttpResponse.BodyHandler.asString());
			int c = 0;
			while (!future.isDone()) {
				System.out.println("Processing not done yet " + c++);
			}
			handleResponse(future.get());
		} catch (InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		}
	}

	private static void handleResponse(HttpResponse<String> response) {
		System.out.println(response.statusCode());
		response.headers().map().forEach((k, v) -> System.out.println(k + ", " + v));
		System.out.println(response.body());
	}

	private static void sendSyncRequest() {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(URI.create("https://postman-echo.com/get")).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());
			handleResponse(response);
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
