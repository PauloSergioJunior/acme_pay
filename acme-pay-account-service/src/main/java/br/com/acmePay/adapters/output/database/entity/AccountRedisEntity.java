package br.com.acmePay.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("Account")
public class AccountRedisEntity implements Serializable {

    @Id
    private String document;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;

}

