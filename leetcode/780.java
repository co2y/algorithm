class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//         if (sx == tx && sy == ty)
//             return true;

//         if (sx > tx || sy > ty)
//             return false;

//         return (reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty));
        while (sx < tx && sy < ty) {
            
            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;
        }
        
        return (sx == tx && sy <= ty && (ty - sy) % sx == 0) || (sy == ty && sx <= tx && (tx - sx) % sy == 0);
    }
}