package triangle

import (
        "math"
)

type Kind string

const (
        Equ Kind = "equilateral"
        Iso Kind = "isoceles"
        Sca Kind = "scalene"
        NaT = "not a triangle"
)

type Triangle struct {
        a, b, c float64
}

func KindFromSides(a, b, c float64) Kind {
        var triangle = Triangle{a: a, b: b, c: c}
        if isValid(triangle) {
                if isEquilateral(triangle) {
                        return Equ
                }
                if isIsocele(triangle) {
                        return Iso
                }
                return Sca
        }
        return NaT
}

func isValid(triangle Triangle) bool {
        if !math.IsNaN(triangle.a) && !math.IsNaN(triangle.b) && !math.IsNaN(triangle.c) && triangle.a > 0 && triangle.b > 0 && triangle.c > 0 {
                if triangleInequality(triangle) {
                        return true
                }
        }
        return false
}

func triangleInequality(triangle Triangle) bool {
        return triangle.a + triangle.b > triangle.c && triangle.a + triangle.c > triangle.b && triangle.b + triangle.c > triangle.a
}

func isIsocele(triangle Triangle) bool {
        return triangle.a == triangle.b || triangle.b == triangle.c || triangle.a == triangle.c
}

func isEquilateral(triangle Triangle) bool {
        return triangle.a == triangle.b && triangle.b == triangle.c
}
