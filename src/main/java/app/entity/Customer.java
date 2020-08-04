package app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long user_id;

    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String surname;
    @Column(nullable = false)
    public int maxPayableValue;
    @Column
    public int overdueInDays;
}
