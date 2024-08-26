package kroryi.springex.domain;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String user_id;
    private String user_name;
    private LocalDate register_date;
    private String user_pw;
}
