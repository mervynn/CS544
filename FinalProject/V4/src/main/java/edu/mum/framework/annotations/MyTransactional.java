package edu.mum.framework.annotations;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyTransactional {
    TxType value() default TxType.REQUIRED;

    public static enum TxType {
        REQUIRED,
        REQUIRES_NEW,
        MANDATORY,
        SUPPORTS,
        NOT_SUPPORTED,
        NEVER;

        private TxType() {
        }
    }
}
