package org.jboss.unimbus.opentracing.jaeger.impl;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.uber.jaeger.Configuration;
import io.opentracing.Tracer;
import org.jboss.unimbus.condition.annotation.RequiredClassPresent;
import org.jboss.unimbus.opentracing.TracerProvider;

/**
 * Created by bob on 2/22/18.
 */
@ApplicationScoped
@RequiredClassPresent("com.uber.jaeger.Configuration")
@Priority(1000)
public class JaegerTracerProvider implements TracerProvider {
    @Override
    public Tracer get() {
        return this.configuration.getTracer();
    }

    @Inject
    Configuration configuration;

}