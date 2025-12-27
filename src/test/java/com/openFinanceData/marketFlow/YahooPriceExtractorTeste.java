// package com.openFinanceData.marketFlow;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertNull;

// import java.math.BigDecimal;

// import org.junit.jupiter.api.Test;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.openFinanceData.marketFlow.marketDataExtractors.YahooPriceExtractor;

// class YahooPriceExtractorTest {

//     private final ObjectMapper mapper = new ObjectMapper();

//     @Test
//     void shouldExtractRegularMarketPrice() throws Exception {
//         String json = """
//         {
//           "quoteResponse": {
//             "result": [
//               {
//                 "regularMarketPrice": {
//                   "raw": 192.45,
//                   "fmt": "192.45"
//                 }
//               }
//             ],
//             "error": null
//           }
//         }
//         """;

//         JsonNode node = mapper.readTree(json);

//         BigDecimal price = YahooPriceExtractor.extractRegularMarketPrice(node);

//         assertNotNull(price);
//         assertEquals(new BigDecimal("192.45"), price);
//     }

//     @Test
//     void shouldReturnNullWhenQuoteResponseIsMissing() throws Exception {
//         String json = "{}";

//         JsonNode node = mapper.readTree(json);

//         BigDecimal price = YahooPriceExtractor.extractRegularMarketPrice(node);

//         assertNull(price);
//     }

//     @Test
//     void shouldReturnNullWhenResultArrayIsEmpty() throws Exception {
//         String json = """
//         {
//           "quoteResponse": {
//             "result": []
//           }
//         }
//         """;

//         JsonNode node = mapper.readTree(json);

//         BigDecimal price = YahooPriceExtractor.extractRegularMarketPrice(node);

//         assertNull(price);
//     }

//     @Test
//     void shouldReturnNullWhenPriceIsMissing() throws Exception {
//         String json = """
//         {
//           "quoteResponse": {
//             "result": [
//               {
//                 "someOtherField": {}
//               }
//             ]
//           }
//         }
//         """;

//         JsonNode node = mapper.readTree(json);

//         BigDecimal price = YahooPriceExtractor.extractRegularMarketPrice(node);

//         assertNull(price);
//     }

//     @Test
//     void shouldReturnNullWhenRawPriceIsNull() throws Exception {
//         String json = """
//         {
//           "quoteResponse": {
//             "result": [
//               {
//                 "regularMarketPrice": {
//                   "raw": null
//                 }
//               }
//             ]
//           }
//         }
//         """;

//         JsonNode node = mapper.readTree(json);

//         BigDecimal price = YahooPriceExtractor.extractRegularMarketPrice(node);

//         assertNull(price);
//     }
// }
