package com.parabolika.irc.message.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.parabolika.irc.event.enums.IRCEventTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface EventType {
	IRCEventTypes value() default IRCEventTypes.NONE;
}
