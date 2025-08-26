package cn.bigears.pattern.chain;

import cn.bigears.pattern.chain.validation.Validator;

/**
 * MainChain
 * @author shenyang
 * @date 2025-08-26
 */
public class MainChain {

    public static void main(String[] args) throws Exception {
        User tom = new User("tom", 19);
        Validator validator = new Validator();
        validator.validate(tom);

    }


}
