package com.example.demo5.promo;

import com.example.demo5.promo.model.PromoMatrix;
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

import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

@Api(value = "promo", description = "the promo API")
@RequestMapping(value = "")
public interface PromoApi {

  Logger log = LoggerFactory.getLogger(PromoApi.class);

  default Optional<ObjectMapper> getObjectMapper() {
    return Optional.empty();
  }

  default Optional<HttpServletRequest> getRequest() {
    return Optional.empty();
  }

  default Optional<String> getAcceptHeader() {
    return getRequest().map(r -> r.getHeader("Accept"));
  }

  @ApiOperation(value = "Загрузка новой матрицы промо-механик", nickname = "setMatrix", notes = "",
      tags = {"Конфигурация промо-механик",})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Правила успешно загружены"),
      @ApiResponse(code = 400, message = "Некорректный запрос")})
  @RequestMapping(value = "/promo",
      produces = {"application/json"},
      consumes = {"application/json"},
      method = RequestMethod.POST)
  default ResponseEntity<Void> setMatrix(
      @ApiParam(value = "Матрица промо-механик",
          required = true) @Valid @RequestBody PromoMatrix promoMatrix) {
    if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
      return setMatrixHandler(promoMatrix);
    } else {
      log.warn(
          "ObjectMapper or HttpServletRequest not configured in default PromoApi interface so no example is generated");
    }
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  default ResponseEntity<Void> setMatrixHandler(PromoMatrix promoMatrix) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

}
