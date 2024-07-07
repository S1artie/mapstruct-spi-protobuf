package de.firehead.mapstruct.spi.protobuf.builderprovider;

import org.mapstruct.ap.internal.util.ImmutablesConstants;
import org.mapstruct.ap.spi.BuilderInfo;
import org.mapstruct.ap.spi.BuilderProvider;
import org.mapstruct.ap.spi.DefaultBuilderProvider;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;

import javax.lang.model.type.TypeMirror;

public class DelegatingBuilderProvider implements BuilderProvider {

    protected BuilderProvider delegate;

    @Override
    public void init(MapStructProcessingEnvironment aProcessingEnvironment) {
        if (delegate == null) {
            if (aProcessingEnvironment.getElementUtils().getTypeElement(ImmutablesConstants.IMMUTABLE_FQN) != null) {
                delegate = new ImmutablesBuilderProvider();
            } else {
                delegate = new DefaultBuilderProvider();
            }
        }

        delegate.init(aProcessingEnvironment);
    }

    @Override
    public BuilderInfo findBuilderInfo(TypeMirror aType) {
        return delegate.findBuilderInfo(aType);
    }

}
