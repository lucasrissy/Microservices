package com.example.cards.controller;

import com.example.cards.constant.CardConstant;
import com.example.cards.dto.CardDto;
import com.example.cards.dto.ResponseDto;
import com.example.cards.service.ICardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class CardController {

    private ICardService cardService;

    @Operation(
            summary = "Create Card REST API",
            description = "REST API to create new Card inside EazyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "HTTP Status CREATED"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDto> createCard(@RequestBody CardDto dto){

        cardService.createdCard(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardConstant.STATUS_201, CardConstant.MESSAGE_201));
    }

    @Operation(
            summary = "Find Card REST API",
            description = "REST API to find Card inside EazyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )

    @GetMapping("/fetch")
    public ResponseEntity<CardDto> findCardByMobileNumber(@RequestParam
                                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                                  String mobileNumber){


        return ResponseEntity.status(HttpStatus.FOUND).body(cardService.findCardByMobileNumber(mobileNumber));
    }

    @Operation(
            summary = "Update Card REST API",
            description = "REST API to update Card inside EazyBank"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP Status OK"
                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Expectation Failed"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP Status Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardDto dto){

        boolean isUpdate = cardService.updateCard(dto);

        if(isUpdate){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstant.STATUS_200, CardConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardConstant.STATUS_417, CardConstant.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                  String mobileNumber){

        boolean isDeleted = cardService.deleteCard(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstant.STATUS_200, CardConstant.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardConstant.STATUS_417, CardConstant.MESSAGE_417_DELETE));
        }
    }
}
