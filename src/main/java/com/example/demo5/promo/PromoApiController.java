package com.example.demo5.promo;

import com.example.demo5.promo.model.PromoMatrix;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

@Controller
public class PromoApiController implements PromoApi {

  public static final ResponseEntity<Void> OK_RESPONSE_ENTITY =
      new ResponseEntity<>(HttpStatus.OK);
  private final ObjectMapper objectMapper;

  private final HttpServletRequest request;
  private PromoMatrixService promoMatrixService;

  @org.springframework.beans.factory.annotation.Autowired
  public PromoApiController(ObjectMapper objectMapper, HttpServletRequest request,
      PromoMatrixService promoMatrixService) {
    this.objectMapper = objectMapper;
    this.request = request;

    this.promoMatrixService = promoMatrixService;
  }

  @Override
  public Optional<ObjectMapper> getObjectMapper() {
    return Optional.ofNullable(objectMapper);
  }

  @Override
  public Optional<HttpServletRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<Void> setMatrixHandler(final PromoMatrix promoMatrix) {
    promoMatrixService.store(promoMatrix);
    return OK_RESPONSE_ENTITY;
  }

}
