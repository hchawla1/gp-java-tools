/*  
 * Copyright IBM Corp. 2017
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

import java.io.*
import java.lang.reflect.*
import java.util.*
import java.util.regex.*
import com.ibm.g11n.pipeline.maven.*;
import com.google.gson.*

try {
    println "verifying that download happened successfully"
    String location = bldDir + "/it/t4-basic-download-success"
    String targetLocation = location + "/target/classes/com/bundle1"
    def dir = new File(targetLocation)
    int filecount = 0
    int keycount = 5 // including opening and closing braces which take 1 line each
    dir.traverse { file ->
    	if (!file.directory) {
        	if (file.name.endsWith("json")) {
        		File jsonfile = new File(targetLocation + "/"+file.name)
      			def lines = jsonfile.readLines()
      			println file.name + lines.size()
      			assert lines.size() == keycount
      			filecount++
        	}
    	}
    }
    assert filecount == 10
} catch( Throwable t ) {
    t.printStackTrace()
    return false
}
