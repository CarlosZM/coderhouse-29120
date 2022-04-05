package com.coderhouse.session.ten.controllers;

import com.coderhouse.session.ten.controllers.request.DocumentCreateRequest;
import com.coderhouse.session.ten.controllers.request.NameCreateRequest;
import com.coderhouse.session.ten.controllers.response.TokenSignResponse;
import com.coderhouse.session.ten.domain.DocumentType;
import com.coderhouse.session.ten.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/operation")
public class OperationController {

    private final JwtEncoder encoder;

    private final JwtDecoder decoder;

    @Autowired
    public OperationController(JwtEncoder encoder, JwtDecoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    @GetMapping("/names")
    public TokenSignResponse names(@RequestBody NameCreateRequest nameCreateRequest) {
        return this.createToken(new PersonTokenCarrier(new Person(nameCreateRequest.getFirstName(), nameCreateRequest.getLastName(), null, null, null, null), RegisterStep.NAMES));
    }

    @GetMapping("/document")
    public TokenSignResponse document(@RequestBody DocumentCreateRequest documentCreateRequest) throws Exception {
        PersonTokenCarrier oldCarrier = this.getToken(documentCreateRequest.getJwt());
        if (!oldCarrier.getStep().isNext(RegisterStep.DOCUMENT)) {
            throw new Exception("INVALID STEP");
        }
        oldCarrier.setStep(RegisterStep.DOCUMENT);
        oldCarrier.getPerson().setDocumentId(documentCreateRequest.getDocumentId());
        oldCarrier.getPerson().setDocumentType(DocumentType.DNI);
        return this.createToken(oldCarrier);
    }

    public TokenSignResponse createToken(PersonTokenCarrier personTokenCarrier) {
        Instant now = Instant.now();
        long expiry = 36000L;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .claim("data", personTokenCarrier)
                .build();

        return new TokenSignResponse(this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
    }

    public PersonTokenCarrier getToken(String token) throws JsonProcessingException {

        return new ObjectMapper().readValue(this.decoder.decode(token).getClaimAsString("data"), PersonTokenCarrier.class);
    }
}
