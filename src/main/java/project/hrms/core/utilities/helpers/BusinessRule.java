package project.hrms.core.utilities.helpers;

import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccesResult;

public class BusinessRule {
    public static Result run(Result... results){
        for (var result:results) {
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccesResult();
    }
}
