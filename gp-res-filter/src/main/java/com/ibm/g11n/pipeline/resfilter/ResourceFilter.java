/*
 * Copyright IBM Corp. 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.g11n.pipeline.resfilter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Resource filter interface - converting input format data to key-value pairs
 * and key-value pairs to output format data.
 *
 * @author Yoshito Umaoka
 */
public interface ResourceFilter {
    public static String[] PLURA_CATEGORIES = {"zero", "=0", "one", "=1", "two", "=2", "few", "many", "other"};

    Bundle parse(InputStream inStream) throws IOException;

    void write(OutputStream outStream, String language, Bundle resource) throws IOException;

    void merge(InputStream base, OutputStream outStream, String language, Bundle resource) throws IOException;    
    
}
