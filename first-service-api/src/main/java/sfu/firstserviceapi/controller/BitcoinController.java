package sfu.firstserviceapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sfu.firstserviceapi.dto.BitcoinDto;
import sfu.firstserviceapi.dto.ErrorResponseDto;
import sfu.firstserviceapi.service.BitcoinApiService;

@RestController
public class BitcoinController {
    private final BitcoinApiService bitcoinApiService;

    public BitcoinController(BitcoinApiService bitcoinApiService) {
        this.bitcoinApiService = bitcoinApiService;
    }

    private final static String API_GET_BITCOIN = "/api/bitcoin";


    @Operation(summary = "Получить текущий курс биткоина", description = "Возвращает актуальную информацию о курсе биткоина в разных валютах (USD, GBP, EUR).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный ответ с курсом биткоина",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BitcoinDto.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "time": {
                                        "updated": "Sep 7, 2024 08:55:27 UTC",
                                        "updatedISO": "2024-09-07T08:55:27+00:00",
                                        "updateduk": "Sep 7, 2024 at 09:55 BST"
                                      },
                                      "disclaimer": "This data was produced from the CoinDesk Bitcoin Price Index (USD)...",
                                      "chartName": "Bitcoin",
                                      "bpi": {
                                        "USD": {
                                          "code": "USD",
                                          "symbol": "&#36;",
                                          "rate": "54,375.987",
                                          "description": "United States Dollar",
                                          "rate_float": 54375.99
                                        },
                                        "GBP": {
                                          "code": "GBP",
                                          "symbol": "&pound;",
                                          "rate": "41,407.26",
                                          "description": "British Pound Sterling",
                                          "rate_float": 41407.258
                                        },
                                        "EUR": {
                                          "code": "EUR",
                                          "symbol": "&euro;",
                                          "rate": "49,030.827",
                                          "description": "Euro",
                                          "rate_float": 49030.83
                                        }
                                      }
                                    }
                                    """))),
            @ApiResponse(responseCode = "500", description = "Ошибка при получении данных о биткоине",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class),
                            examples = @ExampleObject(value = """
                                    {
                                    "error": "Something wrong"
                                    }
                                    """)))
    })
    @GetMapping(API_GET_BITCOIN)
    public ResponseEntity<BitcoinDto> getCurrentBitcoin() {
        return ResponseEntity.ok(bitcoinApiService.getCurrentBitcoin());
    }
}
