/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.function.generator;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.function.RegionFunction;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.world.generation.ConfiguredFeatureType;

/**
 * Generates forests by searching for the ground starting from the given upper Y
 * coordinate for every column given.
 */
public class FeatureGenerator implements RegionFunction {

    private final ConfiguredFeatureType featureType;
    private final EditSession editSession;

    /**
     * Create a new instance.
     *
     * @param editSession the edit session
     * @param featureType the feature type
     */
    public FeatureGenerator(EditSession editSession, ConfiguredFeatureType featureType) {
        this.editSession = editSession;
        this.featureType = featureType;
    }

    @Override
    public boolean apply(BlockVector3 position) throws WorldEditException {
        return editSession.getWorld().generateFeature(featureType, editSession, position);
    }
}
