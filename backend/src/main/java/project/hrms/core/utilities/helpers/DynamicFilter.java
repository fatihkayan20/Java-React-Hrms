package project.hrms.core.utilities.helpers;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

import java.util.function.Predicate;

public class DynamicFilter {

    public static <T> DataResult<T> run(DataResult<DynamicFilterClass>... results){
        Predicate<String > predicateLast = null;
        for (var result:results) {
            if(result.isSuccess()){
                if(predicateLast == null){
                    predicateLast= result.getData().getPredicate();
                }else{
                    if(result.getData().getPredicateType() == PredicateType.OR){
                        predicateLast.or(result.getData().getPredicate());
                    }else if(
                            result.getData().getPredicateType() == PredicateType.AND
                    ){
                        predicateLast.and(result.getData().getPredicate());
                    }
                }

            }
        }



        return new SuccessDataResult(predicateLast);
    }





}
