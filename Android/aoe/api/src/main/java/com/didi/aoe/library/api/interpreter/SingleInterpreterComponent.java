/*
 * Copyright 2019 The AoE Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.didi.aoe.library.api.interpreter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.api.AoeProcessor.InterpreterComponent;
import com.didi.aoe.library.api.StatusCode;

import java.util.List;

/**
 * 单模型翻译组件
 *
 * @param <TInput>
 * @param <TOutput>
 * @author noctis
 */
public abstract class SingleInterpreterComponent<TInput, TOutput> implements
        InterpreterComponent<TInput, TOutput> {
    @Override
    final public void init(@NonNull Context context,
            @Nullable InterpreterComponent.Options interpreterOptions,
            @NonNull List<AoeModelOption> modelOptions,
            @Nullable OnInterpreterInitListener listener) {
        if (modelOptions.size() != 1) {
            listener.onInitResult(InterpreterInitResult.create(StatusCode.STATUS_INNER_ERROR));
            return;
        }

        init(context, interpreterOptions, modelOptions.get(0), listener);
    }

    public abstract void init(@NonNull Context context,
            @Nullable InterpreterComponent.Options interpreterOptions,
            @NonNull AoeModelOption modelOptions,
            @Nullable OnInterpreterInitListener listener);

}
