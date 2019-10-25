package com.example.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.introspect.Annotated;

/**
 * @author shaoxiangen
 * Create in 2019/10/16
 */
public class DemoAnnotationIntrospector extends AnnotationIntrospector {

    @Override
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override
    public Object findSerializationConverter(Annotated a) {
        Encrypted ann = _findAnnotation(a, Encrypted.class);
        return (ann == null) ? null : new EncodeConverter();
    }

    @Override
    public Object findDeserializationConverter(Annotated a)
    {
        Encrypted ann = _findAnnotation(a, Encrypted.class);
        return (ann == null) ? null : new DecodeConverter();
    }
}
