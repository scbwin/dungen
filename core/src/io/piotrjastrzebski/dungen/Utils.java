/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
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
 *
 ******************************************************************************/

package io.piotrjastrzebski.dungen;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Random;

/**
 * Created by PiotrJ on 04/09/15.
 */
public class Utils {

	public static Vector2 pointInCircle (float radius, Vector2 out) {
		return pointInEllipse(radius * 2, radius * 2, out);
	}

	public static Vector2 pointInEllipse (float width, float height, Vector2 out) {
		float t = (float)(MathUtils.random() * Math.PI * 2);
		float u = MathUtils.random() + MathUtils.random();
		float r = (u > 1) ? (2 - u) : u;
		out.set(width * r * MathUtils.cos(t) / 2, height * r * MathUtils.sin(t) / 2);
		return out;
	}

	public static Vector2 roundedPointInEllipse (float width, float height, float size, Vector2 out) {
		Utils.pointInEllipse(width, height, out);
		out.x = roundToSize(out.x, size);
		out.y = roundToSize(out.y, size);
		return out;
	}

	public static float roundToSize (float value, float size) {
		return ((Math.round(value / size)) * size);
	}

	public static Vector2 roundToSize (Vector2 value, float size) {
		value.x = roundToSize(value.x, size);
		value.y = roundToSize(value.y, size);
		return value;
	}

	private static Random rng = new Random(TimeUtils.millis());

	public static float rngFloat () {
		return (float)(rng.nextGaussian());
	}

	public static float rngFloat (float mean) {
		return mean + rngFloat();
	}
	public static float rngFloat (float mean, float scale) {
		return mean + rngFloat() * scale;
	}

	public static float roundedRngFloat (float mean, float scale, float size) {
		return Utils.roundToSize(Utils.rngFloat(mean, scale), size);
	}
}
