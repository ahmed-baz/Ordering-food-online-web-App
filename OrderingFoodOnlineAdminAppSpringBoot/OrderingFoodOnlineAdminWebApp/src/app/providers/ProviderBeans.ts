import { AreaBean } from '../lookups/LookupsBeans';

export class ProviderBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public hotline: string;
    public branchList: BranchBean[]
    public categoryList: CategoryBean[]
    public providerUserList: providerUsersBean[]
    constructor(
    ) { }
}

export class BranchBean {
    public id: Number;
    public name: string;
    public nameAr: string;
    public nameEn: string;
    public openAt: Date
    public closeAt: Date
    public phone: string
    public lat: BigInteger
    public lng: BigInteger
    public provider: ProviderBean
    public area: AreaBean
    public deliveryAreaList: DeliveryAreaBean[]
    public userList: providerUsersBean[]
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
    public provider: ProviderBean;
    public productList: productBean[];
    constructor() { };
}

export class providerUsersBean {
    public id: Number;
    public userName: string;
    public password: string;
    public provider: ProviderBean
    public branch: BranchBean;
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
    public category: CategoryBean;

    constructor() { };
}

export class DeliveryAreaBean {
    public id: Number;
    public deliveryFees: number;
    public deliverInMinutes: number;
    public branch: BranchBean;
    public area: AreaBean;

    constructor() { };
}


