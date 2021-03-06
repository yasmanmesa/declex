/**
 * Copyright (C) 2016-2018 DSpot Sp. z o.o
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dspot.declex.override.handler;

import java.util.Map;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;

import org.androidannotations.AndroidAnnotationsEnvironment;
import org.androidannotations.ElementValidation;
import org.androidannotations.annotations.FocusChange;
import org.androidannotations.holder.EComponentWithViewSupportHolder;

import com.dspot.declex.holder.ViewsHolder;
import com.dspot.declex.holder.view_listener.FocusChangeHolder;
import com.dspot.declex.holder.view_listener.ViewListenerHolder;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.IJExpression;

public class FocusChangeHandler extends BaseViewListenerHandler {

	public FocusChangeHandler(AndroidAnnotationsEnvironment environment) {
		super(FocusChange.class, environment);
	}
	
	@Override
	public void validate(Element element, ElementValidation valid) {
		super.validate(element, valid);
		
		if (element instanceof ExecutableElement) {
			ExecutableElement executableElement = (ExecutableElement) element;
			validatorHelper.returnTypeIsVoid(executableElement, valid);
		}
	}
	
	@Override
	protected ViewListenerHolder getListenerHolder(String elementName,
			String elementClass, Map<AbstractJClass, IJExpression> declForListener,
			Element element, ViewsHolder viewsHolder, EComponentWithViewSupportHolder holder) {
		
		return holder.getPluginHolder(new FocusChangeHolder(holder));
	}
}
