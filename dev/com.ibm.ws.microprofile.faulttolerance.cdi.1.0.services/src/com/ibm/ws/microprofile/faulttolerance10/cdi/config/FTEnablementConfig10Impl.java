/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.microprofile.faulttolerance10.cdi.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.ibm.ws.microprofile.faulttolerance.cdi.AbstractFTEnablementConfig;
import com.ibm.ws.microprofile.faulttolerance.cdi.FTEnablementConfig;

/**
 * FT 1.0 implementation for determining whether an annotation is enabled or not
 */
@Component(service = FTEnablementConfig.class, configurationPolicy = ConfigurationPolicy.IGNORE)
public class FTEnablementConfig10Impl extends AbstractFTEnablementConfig {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnnotationEnabled(Annotation ann, Class<?> clazz) {
        return isAnnotationEnabled(ann, clazz, null);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAnnotationEnabled(Annotation ann, Class<?> clazz, Method method) {
        return getActiveAnnotations(clazz).contains(ann.annotationType());
    }

}
