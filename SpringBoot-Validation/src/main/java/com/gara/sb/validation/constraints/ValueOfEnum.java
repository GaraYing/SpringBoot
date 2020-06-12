/*
 * Bean Validation API
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package com.gara.sb.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
@Repeatable(ValueOfEnum.List.class)
public @interface ValueOfEnum {

	Class<? extends Enum<?>> enumClass();
//	String allowableValues() default "";

	/**
	 * the method's name ,which used to validate the enum's value
	 *
	 * @return method's name
	 */
	String enumMethod() default "getValue";

	String message() default "accepted value is not allowed";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};


	/**
	 * Defines several {@link com.fadada.core.common.annotation.ValueOfEnum} annotations on the same element.
	 *
	 * @see com.fadada.core.common.annotation.ValueOfEnum
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		ValueOfEnum[] value();
	}
}
