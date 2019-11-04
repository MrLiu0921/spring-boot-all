package top.zzliup.hikar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Liupan on 2019-10-25 15:46
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;

    private String name;

    private Integer age;
}
