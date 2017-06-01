package com.app.video.capitol.utils.config;

import com.app.video.capitol.dominio.cliente.Cliente;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Carlos
 */
@Component
public class AuthUtils {

    @Value("${authapp.secretkey}")
    private String appSecretKey;

    public String createLoginToken(String host, Cliente cliente) {
        return Jwts.builder()
                .setSubject(cliente.rut())
                .claim("id", cliente.id())
                .setIssuer(host)
                .setIssuedAt(DateTime.now().toDate())
                .signWith(SignatureAlgorithm.HS256, appSecretKey).compact();
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public void setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
    }
}
