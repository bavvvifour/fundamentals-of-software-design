package sfu.firstserviceapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import sfu.firstserviceapi.dto.BitcoinDto;
import sfu.firstserviceapi.exception.CurrentBitcoinException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BitcoinApiService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final static HttpClient httpClient = HttpClient.newHttpClient();

    private final static String BASE_API_URL = "https://api.coindesk.com";
    private final static String BITCOIN_API_URL_SUFFIX = "/v1/bpi/currentprice.json";


    public BitcoinDto getCurrentBitcoin() {
        try {
            HttpRequest request = buildRequest(buildUriForBitcoin());
            HttpResponse<String> response = getResponse(request);

            return objectMapper.readValue(response.body(), BitcoinDto.class);
        } catch (Exception e) {
            throw new CurrentBitcoinException(e.getMessage());
        }

    }

    private static HttpRequest buildRequest(URI uri) {
        return HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
    }

    private static HttpResponse<String> getResponse(HttpRequest httpRequest) throws IOException, InterruptedException {
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    private static URI buildUriForBitcoin() {
        return URI.create(BASE_API_URL + BITCOIN_API_URL_SUFFIX);
    }
}
