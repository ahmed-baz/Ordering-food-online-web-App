import { AreaBean } from '../lookups/LookupsBeans';

export class ProviderBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public hotline: string;
    public branchesBean: BranchBean[];
    public categoriesBean: CategoryBean[]
    public providerUsersBean: providerUsersBean[]
    constructor(
    ) { }
}

export class BranchBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public openAt: Date;
    public closeAt: Date;
    public phone: string
    public lat: BigInteger
    public lng: BigInteger
    public provider: ProviderBean = new ProviderBean()
    public area: AreaBean = new AreaBean()
    public deliveryAreas: DeliveryAreaBean[]
    public providerUsers: providerUsersBean[]
    constructor() { };
}

export class CategoryBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public description: string;
    public descriptionAr: string;
    public descriptionEn: string;
    public provider: ProviderBean = new ProviderBean();
    public productList: productBean[];
    constructor() { };
}

export class providerUsersBean {
    public id: Number;
    public username: string;
    public password: string;
    public provider: ProviderBean = new ProviderBean()
    public branch: BranchBean = new BranchBean()
    constructor() { };
}

export class productBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public description: string;
    public descriptionAr: string;
    public descriptionEn: string;
    public price: number;
    public category: CategoryBean = new CategoryBean();

    constructor() { };
}

export class DeliveryAreaBean {
    public id: Number;
    public deliveryFees: number;
    public deliverInMinutes: number;
    public branchBean: BranchBean = new BranchBean();
    public areaBean: AreaBean = new AreaBean();

    constructor() { };
}


