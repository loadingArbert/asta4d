/*
 * Copyright 2014 astamuse company,Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.astamuse.asta4d.web.form.flow.classical;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.astamuse.asta4d.web.form.flow.base.AbstractFormFlowSnippet;

public abstract class MultiStepFormFlowSnippet extends AbstractFormFlowSnippet {

    protected static Set<String> NonEditSteps = new HashSet<>();
    static {
        NonEditSteps.add(ClassicalFormFlowConstant.STEP_CONFIRM);
        NonEditSteps.add(ClassicalFormFlowConstant.STEP_COMPLETE);
    }

    @Override
    protected boolean renderForEdit(String step, Object form, String fieldName) {
        if (StringUtils.isEmpty(step)) {
            return true;
        } else {
            return !NonEditSteps.contains(step.toLowerCase());
        }
    }
}
