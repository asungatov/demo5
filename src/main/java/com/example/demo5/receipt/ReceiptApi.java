package com.example.demo5.receipt;

import com.example.demo5.receipt.model.FinalPriceReceipt;
import com.example.demo5.receipt.model.ShoppingCart;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

@Api(value = "receipt", description = "the receipt API")
@RequestMapping(value = "")
public interface ReceiptApi {

  Logger log = LoggerFactory.getLogger(ReceiptApi.class);

  default Optional<ObjectMapper> getObjectMapper() {
    return Optional.empty();
  }

  default Optional<HttpServletRequest> getRequest() {
    return Optional.empty();
  }

  default Optional<String> getAcceptHeader() {
    return getRequest().map(r -> r.getHeader("Accept"));
  }

  @ApiOperation(value = "Расчитать стоимость позиций в чеке для указанной корзины",
      nickname = "calculate", notes = "", response = FinalPriceReceipt.class,
      tags = {"Расчет чека",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Стоимость успешно расчитана",
          response = FinalPriceReceipt.class),
      @ApiResponse(code = 400, message = "Некорректный запрос")})
  @RequestMapping(value = "/receipt",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.POST)
  default ResponseEntity<FinalPriceReceipt> calculate(
      @ApiParam(value = "Данное о магазине и товарах в корзине",
          required = true) @Valid @RequestBody ShoppingCart cart) {
    if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
      return calculateHandler(cart);
      // return new ResponseEntity<>(getObjectMapper().get().readValue("{ \"total\" :
      // 5.962133916683182377482808078639209270477294921875, \"discount\" :
      // 0.80082819046101150206595775671303272247314453125, \"positions\" : [ { \"price\" :
      // 6.02745618307040320615897144307382404804229736328125, \"regularPrice\" :
      // 1.46581298050294517310021547018550336360931396484375, \"name\" : \"name\", \"id\" : \"id\"
      // }, { \"price\" : 6.02745618307040320615897144307382404804229736328125, \"regularPrice\" :
      // 1.46581298050294517310021547018550336360931396484375, \"name\" : \"name\", \"id\" : \"id\"
      // } ]}", FinalPriceReceipt.class), HttpStatus.NOT_IMPLEMENTED);

    } else {
      log.warn(
          "ObjectMapper or HttpServletRequest not configured in default ReceiptApi interface so no example is generated");
    }
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  default ResponseEntity<FinalPriceReceipt> calculateHandler(ShoppingCart cart) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  };

}
