package eu.morozik.transportagency.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credentials")
public class Credential extends BaseEntity{
    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "credential")
    private User user;
}
