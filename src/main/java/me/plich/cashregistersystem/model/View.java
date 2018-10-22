package me.plich.cashregistersystem.model;

public class View {
    public static class Public { }
    static class ExtendedPublic extends Public { }
    static class Internal extends ExtendedPublic { }
}