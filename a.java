public class a {
public static void main(String[] args) {

    Base base = new Base();

    // приватный тут нельзя
    
    Base.PackagePrivateInner packagePrivateInner = base.new PackagePrivateInner();
    
    Base.ProtectedInner protectedInner = base.new ProtectedInner();

    Base.PublicInner publicInner = base.new PublicInner();

}

}

class Base {
    
    Base(){
        new PackagePrivateInner();
    }
    // доступен только внутри класса
    private class PrivateInner { 
    }

    // доступен только в пакете
    class PackagePrivateInner {
    }

    // доступен в пакете и в наследниках
    protected class ProtectedInner {
    }

    // доступен везде
    public class PublicInner {
    }

}

