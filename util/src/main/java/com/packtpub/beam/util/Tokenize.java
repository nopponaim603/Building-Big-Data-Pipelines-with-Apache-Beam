/**
 * Copyright 2021-2021 Packt Publishing Limited
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
package com.packtpub.beam.util;

import java.util.Arrays;
import java.util.List;
import org.apache.beam.sdk.transforms.FlatMapElements;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;

public class Tokenize extends PTransform<PCollection<String>, PCollection<String>> {

  public static Tokenize of() {
    return new Tokenize();
  }

  @Override
  public PCollection<String> expand(PCollection<String> input) {
    return input.apply(FlatMapElements.into(TypeDescriptors.strings()).via(Tokenize::toWords));
  }

  private static List<String> toWords(String input) {
    return Arrays.asList(input.split("\\W+"));
  }
}
