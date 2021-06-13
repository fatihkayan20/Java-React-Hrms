package project.hrms.core.utilities.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DynamicFilterClass {
    private Predicate<String> predicate;
    private PredicateType predicateType;


}
