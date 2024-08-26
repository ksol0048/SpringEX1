package kroryi.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String link;

    String[] types;
    String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public int getSkip() {
        return (page - 1) * 10;
    }

    public String getLink() {
        StringBuilder sb = new StringBuilder();
        sb.append("page=" + this.page);
        sb.append("&size=" + this.size);
        if (finished) {
            sb.append("&finished=on");
        }

        if (types != null && types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                sb.append("&types=" + types[i]);
            }
        }
        if (keyword != null) {
            try {
                sb.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if (from != null) {
            sb.append("&from=" + from.toString());
        }

        if (to != null) {
            sb.append("&to=" + to.toString());
        }
        return sb.toString();
    }



    public boolean checkType(String type) {
        if (types == null || types.length == 0) {
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
