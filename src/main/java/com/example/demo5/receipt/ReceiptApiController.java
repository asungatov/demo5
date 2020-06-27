package com.example.demo5.receipt;

import com.example.demo5.receipt.model.FinalPriceReceipt;
import com.example.demo5.receipt.model.ShoppingCart;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

@Controller
public class ReceiptApiController implements ReceiptApi {

  private final ObjectMapper objectMapper;

  private final HttpServletRequest request;
  private ReceiptService receiptService;

  @Autowired
  public ReceiptApiController(ObjectMapper objectMapper, HttpServletRequest request,
      ReceiptService receiptService) {
    this.objectMapper = objectMapper;
    this.request = request;
    this.receiptService = receiptService;
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
  public ResponseEntity<FinalPriceReceipt> calculateHandler(final ShoppingCart cart) {
    final FinalPriceReceipt finalPriceReceiptResponseEntity = receiptService.applyDiscount(cart);
    return new ResponseEntity<FinalPriceReceipt>(finalPriceReceiptResponseEntity, HttpStatus.OK) ;
  }

}
